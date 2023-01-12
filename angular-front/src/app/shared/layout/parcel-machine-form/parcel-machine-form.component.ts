import {
  AfterViewInit,
  Component,
  ElementRef,
  OnDestroy,
  OnInit,
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
  public parcelCode: string = '';
  public parcelAddress: string = '';
  private parcelMachineService: ParcelMachineService;
  public parcelMachines: ParcelMachine[] = [];
  public showParcelForm: boolean = true;
  private inputSub?: Subscription;

  constructor(parcelMachineService: ParcelMachineService) {
    this.parcelMachineService = parcelMachineService;
  }

  ngOnInit(): void {
    this.parcelMachines = this.parcelMachineService.getParcelMachines();
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
    this.showParcelForm = false;
  }

  ngOnDestroy(): void {
    this.inputSub?.unsubscribe();
  }
}
