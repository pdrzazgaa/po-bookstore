import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-close-message-popup',
  templateUrl: './close-message-popup.component.html',
  styleUrls: ['./close-message-popup.component.scss'],
})
export class CloseMessagePopupComponent implements OnInit {
  @Input() message: string = '';
  @Input() mode?: 'green' | 'red';
  @Output() isClosed = new EventEmitter<boolean>();
  constructor() {}

  ngOnInit(): void {}

  onCloseButtonClick() {
    this.isClosed.emit(true);
  }
}
