import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { DatepickerModule } from "ng2-bootstrap";

import { AppComponent } from './app.component';
import {UsersListComponent} from "./users-list/users-list.component";
import {UserComponent} from "./user/user.component";
import {UsersService} from "./users/users-service.service";
import {UserFormService} from "./users/user-form.service";
import {UserEditComponent} from "./user-edit/user-edit.component";
import {ActivitiesService} from "./activities/activities.service";
import {ActivityFormService} from "./activities/activity-form.service";
import {ActivitiesListComponent} from "./activities/activities-list.component";
import {ActivityEditComponent} from "./activities/activity-edit.component";
import {ApiService} from './api/api.service';
import {routing} from './app.routes';
import { AttendanceComponent } from './attendance/attendance.component';

@NgModule({
  declarations: [
  AppComponent,
  UserComponent,
  UserEditComponent,
  UsersListComponent,
  ActivityEditComponent,
  ActivitiesListComponent,
  AttendanceComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    routing,
    DatepickerModule.forRoot()
  ],
  providers: [ApiService, UsersService, UserFormService, ActivitiesService, ActivityFormService],
  bootstrap: [AppComponent]
})
export class AppModule { }
