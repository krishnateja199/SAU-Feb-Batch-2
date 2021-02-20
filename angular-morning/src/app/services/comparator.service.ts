import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ComparatorService {
  bulkSort(data, colName, type) {
    return data.sort(this.comparator(colName, type));
  }

  comparator(colName, type) {
    if (type === 'asc') {
      return function (a, b) {
        if (a[colName] < b[colName]) {
          return -1;
        }
        if (a[colName] > b[colName]) {
          return 1;
        }
        return 0;
      };
    } else {
      return function (a, b) {
        if (a[colName] < b[colName]) {
          return 1;
        }
        if (a[colName] > b[colName]) {
          return -1;
        }
        return 0;
      };
    }
  }

  constructor() {}
}
