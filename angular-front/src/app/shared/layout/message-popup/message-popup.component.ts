import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { Subscription, timer } from 'rxjs';

@Component({
  selector: 'app-message-popup',
  templateUrl: './message-popup.component.html',
  styleUrls: ['./message-popup.component.scss'],
})
export class MessagePopupComponent implements OnInit, OnDestroy {
  @Input() mode: 'accept' | 'deny' = 'accept';
  @Input() message: string = '';
  appear: boolean = false;
  disappear: boolean = false;
  private appearSub?: Subscription;
  private disappearSub?: Subscription;

  constructor() {}

  ngOnInit(): void {
    this.appearSub = timer(500).subscribe(() => (this.appear = true));
    this.disappearSub = timer(2500).subscribe(() => (this.disappear = true));
  }

  ngOnDestroy(): void {
    this.appearSub?.unsubscribe();
    this.disappearSub?.unsubscribe();
  }
}
