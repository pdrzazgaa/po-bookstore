import {
  AfterViewInit,
  Component,
  ElementRef,
  EventEmitter,
  OnDestroy,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import { ParcelMachine, ParcelMachineService } from 'src/app/core';
import { Subscription, debounceTime, fromEvent } from 'rxjs';

@Component({
  selector: 'app-parcel-machine-form',
  templateUrl: './parcel-machine-form.component.html',
  styleUrls: ['./parcel-machine-form.component.scss'],
})
export class ParcelMachineFormComponent implements OnInit, AfterViewInit, OnDestroy {
  @ViewChild('parcelSearchInput') input!: ElementRef;
  @Output() chosenParcelChanged = new EventEmitter<ParcelMachine>();
  public parcelCode: string = '';
  public parcelAddress: string = '';
  private parcelMachineService: ParcelMachineService;
  public parcelMachines: ParcelMachine[] = [];
  private inputSub?: Subscription;
  private parcelSub?: Subscription;

  constructor(parcelMachineService: ParcelMachineService) {
    this.parcelMachineService = parcelMachineService;
  }

  ngOnInit(): void {
    this.parcelMachines = this.parcelMachineService.getParcelMachines();
    this.parcelSub = this.parcelMachineService.parcelsChanged.subscribe(
      (parcels: ParcelMachine[]) => {
        this.parcelMachines = parcels;
      }
    );
  }

  ngAfterViewInit(): void {
    this.inputSub = fromEvent(this.input.nativeElement, 'keyup')
      .pipe(debounceTime(500))
      .subscribe(() => {
        this.parcelMachines = this.parcelMachineService.getParcelMachinesFiltered(
          this.input.nativeElement.value
        );
      });
  }

  onParcelMachineClick(parcelMachine: ParcelMachine) {
    this.parcelAddress = parcelMachine.address;
    this.parcelCode = parcelMachine.code;
  }

  onSubmitButtonClick() {
    this.chosenParcelChanged.emit({ code: this.parcelCode, address: this.parcelAddress });
  }

  ngOnDestroy(): void {
    this.inputSub?.unsubscribe();
    this.parcelSub?.unsubscribe();
  }
}
