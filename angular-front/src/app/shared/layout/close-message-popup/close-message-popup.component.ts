import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-close-message-popup',
  templateUrl: './close-message-popup.component.html',
  styleUrls: ['./close-message-popup.component.scss'],
})
export class CloseMessagePopupComponent implements OnInit {
  @Input() message: string = '';
  @Input() mode: 'green' | 'red' = 'green';
  public isHidden: boolean = false;
  constructor() {}

  ngOnInit(): void {}

  onCloseButtonClick() {
    this.isHidden = true;
  }
}
