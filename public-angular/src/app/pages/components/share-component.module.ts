import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import {DashboardBoxComponent} from "./dashboard-box/dashboard-box.component";
@NgModule({
    imports: [
      CommonModule,
      FormsModule,
      ReactiveFormsModule

    ],
    declarations: [
        DashboardBoxComponent,
    ],
    exports: [
        DashboardBoxComponent,
    ],
  })
  export class ShareComponentModule { }
