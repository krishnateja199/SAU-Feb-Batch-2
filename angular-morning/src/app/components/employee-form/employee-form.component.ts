import { TableService } from '../../services/table.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css'],
})
export class EmployeeFormComponent implements OnInit {
  public title = 'Add Employee Details Below';
  public IdNo = '1';
  public employeeForm: FormGroup;
  public submitted = false;
  @Output() public createEntry = new EventEmitter();

  constructor(
    private formBuilder: FormBuilder,
    private tableService: TableService
  ) {
    let stored = sessionStorage.getItem('lastIdNo');
    if (stored != 'NaN' && stored != null) {
      this.IdNo = (parseInt(stored) + 1).toString();
    } else {
      sessionStorage.setItem('lastIdNo', '1');
    }
    console.log(sessionStorage.getItem('lastIdNo'));
  }

  ngOnInit(): void {
    this.employeeForm = this.formBuilder.group({
      FirstName: ['', [Validators.required]],
      LastName: ['', [Validators.required]],
      ContactNumber: ['', [Validators.required, Validators.maxLength(10)]],
      DOB: ['', [Validators.required]],
      City: ['', [Validators.required]],
      PinCode: ['', [Validators.required, Validators.maxLength(6)]],
      check: [false, [Validators.requiredTrue]],
    });
  }

  createEmployee() {
    if (this.employeeForm.valid) {
      this.submitted = false;
      let employee = this.employeeForm.value;
      console.log(this.employeeForm.value);
      let IDNumber = this.IdNo;
      this.createEntry.emit([employee,IDNumber]);
      sessionStorage.setItem('lastIdNo', this.IdNo);
      this.IdNo = (parseInt(this.IdNo) + 1).toString();
    } else {
      this.submitted = true;
    }
    this.employeeForm.reset();
  }
}
