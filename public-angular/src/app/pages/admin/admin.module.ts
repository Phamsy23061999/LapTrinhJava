import { RouterModule } from '@angular/router';
import { MaterialModule } from './../../shared/material.module';
import { BookManagementComponent } from './admin-subpages/book-management/book-management.component';
import { SidebarMenuModule } from './../components/sidebar-menu/sidebar-menu.module';
import { AdminRoutingModule } from './admin-routing.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { SendEmailModalComponent } from './admin-subpages/borrow-ticket-management/components/borrow-ticket-detail/send-email-modal/send-email-modal.component';
import { TicketManagementComponent } from './admin-subpages/ticket-management/ticket-management.component';
import { TicketListComponent } from './admin-subpages/ticket-management/components/ticket-list/ticket-list.component';
import { InventoryManagementComponent } from './admin-subpages/inventory-management/inventory-management.component';
import { InventoryListComponent } from './admin-subpages/inventory-management/components/inventory-list/inventory-list.component';
import { CreateInventoryComponent } from './admin-subpages/inventory-management/components/create-inventory/create-inventory.component';
import {PipeModule} from "../../pipes/pipe/pipe.module";

@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        AdminRoutingModule,
        MaterialModule,
        SidebarMenuModule,
        PipeModule
    ],
  declarations: [AdminComponent, BookManagementComponent, SendEmailModalComponent, TicketManagementComponent, TicketListComponent, InventoryManagementComponent, InventoryListComponent, CreateInventoryComponent],
  exports: [BookManagementComponent]
})
export class AdminModule { }
