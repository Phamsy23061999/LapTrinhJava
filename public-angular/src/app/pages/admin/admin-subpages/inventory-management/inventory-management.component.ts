import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inventory-management',
  templateUrl: './inventory-management.component.html',
  styleUrls: ['./inventory-management.component.scss']
})
export class InventoryManagementComponent implements OnInit {
  headerItems = [
    {
      itemName: "Danh sách",
      url: "inventory-list",
    },
    {
      itemName: "Tạo mới",
      url: "create-inventory",
    },
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
