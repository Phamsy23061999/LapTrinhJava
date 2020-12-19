import { ManagementDashboardComponent } from './admin-subpages/dashboard/components/management-dashboard/management-dashboard.component';
import { BorrowTicketDetailComponent } from './admin-subpages/borrow-ticket-management/components/borrow-ticket-detail/borrow-ticket-detail.component';
import { BorrowTicketListComponent } from './admin-subpages/borrow-ticket-management/components/borrow-ticket-list/borrow-ticket-list.component';

import { EmployeeDetailComponent } from './admin-subpages/employee-management/components/employee-detail/employee-detail.component';
import { EmployeeListComponent } from './admin-subpages/employee-management/components/employee-list/employee-list.component';
import { ConfirmDeleteCustomerComponent } from './admin-subpages/customer-management/components/customer-detail/confirm-delete-customer/confirm-delete-customer.component';
import { CustomerDetailComponent } from './admin-subpages/customer-management/components/customer-detail/customer-detail.component';
import { CustomerManagementComponent } from './admin-subpages/customer-management/customer-management.component';
import { ConfirmDeleteModalComponent } from './admin-subpages/book-management/components/book-detail/confirm-delete-modal/confirm-delete-modal.component';
import { PipeModule } from 'src/app/pipes/pipe/pipe.module';
import { BookDetailComponent } from './admin-subpages/book-management/components/book-detail/book-detail.component';
import { PaginationModule } from './../../shared/page-pagination/page-pagination.module';
import { MatInputModule } from './../../shared/mat-input/mat-input.module';
import { BookListComponent } from './admin-subpages/book-management/components/book-list/book-list.component';
import { MaterialModule } from './../../shared/material.module';
import { FormsModule } from '@angular/forms';
import { CreateBookComponent } from './admin-subpages/book-management/components/create-book/create-book.component';
import { BookManagementComponent } from './admin-subpages/book-management/book-management.component';
import { AdminComponent } from './admin.component';
import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ItemTableModule } from '../components/item-table/item-table.module';
import { BookRowComponent } from './admin-subpages/book-management/components/book-list/book-row/book-row.component';
import { AddAuthorModalComponent } from './admin-subpages/book-management/components/add-author-modal/add-author-modal.component';
import { AddCategoryModalComponent } from './admin-subpages/book-management/components/add-category-modal/add-category-modal.component';
import { AddSupplierModalComponent } from './admin-subpages/book-management/components/add-supplier-modal/add-supplier-modal.component';
import { CustomerListComponent } from './admin-subpages/customer-management/components/customer-list/customer-list.component';
import { CustomerRowComponent } from './admin-subpages/customer-management/components/customer-list/customer-row/customer-row.component';
import { EmployeeManagementComponent } from './admin-subpages/employee-management/employee-management.component';
import { EmployeeRowComponent } from './admin-subpages/employee-management/components/employee-list/employee-row/employee-row.component';
import { ConfirmDeleteEmployeeComponent } from './admin-subpages/employee-management/components/employee-detail/confirm-delete-employee/confirm-delete-employee.component';

import { BorrowTicketManagementComponent } from './admin-subpages/borrow-ticket-management/borrow-ticket-management.component';
import { BorrowTicketRowComponent } from './admin-subpages/borrow-ticket-management/components/borrow-ticket-list/borrow-ticket-row/borrow-ticket-row.component';
import { ConfirmFinishBorrowTicketModalComponent } from './admin-subpages/borrow-ticket-management/components/borrow-ticket-list/confirm-finish-borrow-ticket-modal/confirm-finish-borrow-ticket-modal.component';
import { CreateBorrowTicketComponent } from './admin-subpages/borrow-ticket-management/components/create-borrow-ticket/create-borrow-ticket.component';

import {DashboardComponent} from "./admin-subpages/dashboard/dashboard.component";
import { SellDashboardComponent } from './admin-subpages/dashboard/components/sell-dashboard/sell-dashboard.component';
import {ShareComponentModule} from "../components/share-component.module";

const routes: Routes = [
    { path: '', component: AdminComponent, children: [
        { path: 'book-management', component: BookManagementComponent, children:[
            { path: 'create-book', component: CreateBookComponent},
            { path: 'book-list', component: BookListComponent},
            { path: 'book-detail/:id', component: BookDetailComponent},
            { path: '', redirectTo: 'book-list',pathMatch: 'full'},
            { path: '**', redirectTo: 'book-list' },
        ]},
        { path: 'customer-management', component: CustomerManagementComponent, children:[
            { path: 'customer-list', component: CustomerListComponent},
            { path: 'customer-detail/:id', component: CustomerDetailComponent},
            { path: '', redirectTo: 'customer-list',pathMatch: 'full'},
            { path: '**', redirectTo: 'customer-list' },
        ]},
        { path: 'employee-management', component: EmployeeManagementComponent, children:[
            { path: 'employee-list', component: EmployeeListComponent},
            { path: 'employee-detail/:id', component: EmployeeDetailComponent},
            { path: '', redirectTo: 'employee-list',pathMatch: 'full'},
            { path: '**', redirectTo: 'employee-list' },
        ]},
        { path: 'borrow-ticket-management', component: BorrowTicketManagementComponent, children:[
            { path: 'create-borrow-ticket', component: CreateBorrowTicketComponent},
            { path: 'borrow-ticket-list', component: BorrowTicketListComponent},
            { path: 'borrow-ticket-detail/:id', component: BorrowTicketDetailComponent},
            { path: '', redirectTo: 'borrow-ticket-list',pathMatch: 'full'},
            { path: '**', redirectTo: 'borrow-ticket-list' },
        ]},
        { path: 'dashboard', component: DashboardComponent, children:[
            { path: 'sell-dashboard', component: SellDashboardComponent},
            { path: 'management-dashboard', component: ManagementDashboardComponent},
            { path: '', redirectTo: 'sell-dashboard',pathMatch: 'full'},
            { path: '**', redirectTo: 'sell-dashboard' },
          ]},
        { path: '', redirectTo: 'book-management',pathMatch: 'full'},
        { path: '**', redirectTo: 'book-management' },
    ]
    }
];
@NgModule({
    imports: [ShareComponentModule, CommonModule, RouterModule.forChild(routes), FormsModule, MaterialModule, ItemTableModule,MatInputModule, PaginationModule, PipeModule],
    exports: [RouterModule, CreateBookComponent, AddSupplierModalComponent, AddAuthorModalComponent, AddCategoryModalComponent],
    declarations: [ CreateBookComponent, AddSupplierModalComponent, AddCategoryModalComponent, BookListComponent, BookRowComponent, BookDetailComponent, ConfirmDeleteModalComponent, AddAuthorModalComponent, CustomerListComponent, CustomerManagementComponent, CustomerRowComponent, CustomerDetailComponent, ConfirmDeleteCustomerComponent, EmployeeManagementComponent, EmployeeListComponent, EmployeeRowComponent, EmployeeDetailComponent, ConfirmDeleteEmployeeComponent, BorrowTicketManagementComponent, BorrowTicketListComponent, BorrowTicketRowComponent, ConfirmFinishBorrowTicketModalComponent, ConfirmFinishBorrowTicketModalComponent, BorrowTicketDetailComponent, CreateBorrowTicketComponent, DashboardComponent, SellDashboardComponent, ManagementDashboardComponent, ConfirmDeleteModalComponent     ],
    providers:[
        DatePipe,
    ]
})
export class AdminRoutingModule { }
