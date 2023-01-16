import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'fromUrl' })
export class FromUrlPipe implements PipeTransform {
  transform(url: string) {
    return url.split('-').join(' ');
  }
}
