import { ComparatorService } from './comparator.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class TableService {
  getSaveData() {
    let data = JSON.parse(sessionStorage.getItem('employeeData'));
    if (data === null) {
      data = [];
      sessionStorage.setItem('employeeData', JSON.stringify(data));
    }
    return data;
  }

  storeData(employee, IdNo) {
    let data = JSON.parse(sessionStorage.getItem('employeeData'));

    data = [
      ...data,
      {
        IdNo: IdNo,
        FirstName: employee.FirstName,
        LastName: employee.LastName,
        ContactNumber: employee.ContactNumber,
        DOB: employee.DOB,
        City: employee.City,
        PinCode: employee.PinCode,
      },
    ];
    sessionStorage.setItem('employeeData', JSON.stringify(data));
    return data;
  }

  updateList(colName, type) {
    let data = JSON.parse(sessionStorage.getItem('employeeData'));
    return this.compare.bulkSort(data, colName, type);
  }

  filterList(employee) {
    let data = JSON.parse(sessionStorage.getItem('employeeData'));
    data = data.filter((data) => {
      return data.IdNo != employee.IdNo;
    });
    sessionStorage.setItem('employeeData', JSON.stringify(data));
    return data;
  }
  constructor(private compare: ComparatorService) {}
}
