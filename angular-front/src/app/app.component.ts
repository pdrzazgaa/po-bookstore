import { Component } from '@angular/core';
import { SvgIconRegistryService } from 'angular-svg-icon';
import data from '../assets/svgs.json';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'landing_page';
  private registry: SvgIconRegistryService;

  constructor(registry: SvgIconRegistryService) {
    this.registry = registry;
  }

  ngOnInit() {
    console.log(data);
    data.svgs.forEach(({ svgName, src }) => {
      this.registry.addSvg(svgName, src);
    });
  }
}
