import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeTableComponent } from './components/employee-table/employee-table.component';
import { EmployeeFormComponent } from './components/employee-form/employee-form.component';
import { EmployeeDataComponent } from './components/employee-data/employee-data.component';
import { CustomDatePipe } from './pipes/custom-date.pipe';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeTableComponent,
    EmployeeFormComponent,
    EmployeeDataComponent,
    CustomDatePipe,
  ],
  imports: [BrowserModule, AppRoutingModule, ReactiveFormsModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
