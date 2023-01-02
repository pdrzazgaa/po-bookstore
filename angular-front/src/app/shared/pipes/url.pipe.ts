import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'url' })
export class UrlPipe implements PipeTransform {
  transform(url: string) {
    return url.toLowerCase().split(' ').join('-');
  }
}
