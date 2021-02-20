import { Component, OnInit } from '@angular/core';
import { TableService } from '../../services/table.service';
@Component({
  selector: 'app-employee-data',
  templateUrl: './employee-data.component.html',
  styleUrls: ['./employee-data.component.css'],
})
export class EmployeeDataComponent implements OnInit {
  public title = 'Employee Data';
  public employeeList = this.TableService.getSaveData();
  constructor(private TableService: TableService) {}

  ngOnInit(): void {}
  sortBy(arr) {
    this.employeeList = this.TableService.updateList(arr[0], arr[1]);
  }

  deleteEmployee(data) {
    this.employeeList = this.TableService.filterList(data);
  }

  createEmployee(arr) {
    this.employeeList = this.TableService.storeData(arr[0], arr[1]);
  }
}
