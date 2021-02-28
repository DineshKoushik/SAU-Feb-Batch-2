import { Injectable, Pipe, PipeTransform } from '@angular/core';

// tslint:disable-next-line: use-pipe-transform-interface
@Injectable({
  providedIn: 'root'
})

@Pipe({name: 'cutomDate'})
export class CustomDateService implements PipeTransform {

  months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

  transform(date: string): string {
    const yy = date.split('-')[0];
    const mm = date.split('-')[1];
    const dd = date.split('-')[2];
    return dd + ' ' + this.months[parseInt(mm, 10) - 1] + ' ' + yy;
  }
}