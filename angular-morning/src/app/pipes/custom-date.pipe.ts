import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'MyDate',
})
export class CustomDatePipe implements PipeTransform {
  getFullMonth(month) {
    let months = [
      'January',
      'February',
      'March',
      'April',
      'May',
      'June',
      'July',
      'August',
      'September',
      'October',
      'November',
      'December',
    ];
    return months[parseInt(month) - 1];
  }
  transform(value: string, format: string) {
    // console.log(value);
    if (format === 'MM_A DD, YYYY') {
      let arr = value.split('-');
      return this.getFullMonth(arr[1]) + ' ' + arr[2] + ' , ' + arr[0];
    } else {
      return value;
    }
  }
}
