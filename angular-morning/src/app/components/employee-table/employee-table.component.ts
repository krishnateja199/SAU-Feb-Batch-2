import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-employee-table',
  templateUrl: './employee-table.component.html',
  styleUrls: ['./employee-table.component.css'],
})
export class EmployeeTableComponent implements OnInit {
  public sort = {
    one: 'asc',
    two: 'asc',
    three: 'asc',
    four: 'asc',
    five: 'asc',
    six: 'asc',
    seven: 'asc',
  };
  public title = 'Employee Data';

  @Input() public employeeList;
  @Output() public sortTable = new EventEmitter();
  @Output() public deleteEmployee = new EventEmitter();
  constructor() {}

  ngOnInit(): void {}

  sortBy(colName) {
    let type = '';
    if (colName === 'FirstName') {
      type = 'two';
    } else if (colName === 'LastName') {
      type = 'three';
    } else if (colName === 'City') {
      type = 'six';
    } else if (colName === 'PinCode') {
      type = 'seven';
    } else if (colName === 'DOB') {
      type = 'five';
    } else if (colName === 'ContactNumber') {
      type = 'four';
    } else if (colName === 'IdNo') {
      type = 'one';
    }
    this.sort[type] = this.sort[type] === 'asc' ? 'dsc' : 'asc';
    let sortType = this.sort[type];
    this.sortTable.emit([colName, sortType]);
  }

  deleteEmp(data) {
    this.deleteEmployee.emit(data);
  }
}
