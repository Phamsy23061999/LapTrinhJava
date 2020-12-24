import { AccountService } from './../../../states/account-store/account.service';
import { Component, OnInit, Pipe } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Pipe({
  name: 'wrapBold'
})
class WrapBold {
  transform(content) {
    return `<b>${content}</b>`;
  }
}

@Component({
  selector: 'app-sidebar-menu',
  templateUrl: './sidebar-menu.component.html',
  styleUrls: ['./sidebar-menu.component.scss']
})
export class SidebarMenuComponent implements OnInit {
  menuItems = [
    {
      iconHtml:`<i class="fas fa-2x fa-chart-bar" aria-hidden="true"></i>`,
      itemTitle: "Tổng quan",
      routerLink: "dashboard"
    },
    {
      iconHtml:`<i class="fa fa-2x fa-book" aria-hidden="true"></i>`,
      itemTitle: "Quản lý sách",
      routerLink: "book-management"
    },
    {
      iconHtml:`<i class="fa fa-2x fa-address-card" aria-hidden="true"></i>`,
      itemTitle: "Quản lý khách hàng",
      routerLink: "customer-management"
    },
    {
      iconHtml:`<i class="fa fa-2x fa-user" aria-hidden="true"></i>`,
      itemTitle: "Quản lý nhân viên",
      routerLink: "employee-management"
    },
    {
      iconHtml:`<i class="far fa-2x fa-map"></i>`,
      itemTitle: "Quản lý mượn trả",
      routerLink: "borrow-ticket-management"
    },
    {
      iconHtml: `<i class="fa fa-2x fa-ticket" aria-hidden="true"></i>`,
      itemTitle: "Quản lý phiếu phạt",
      routerLink: "ticket-management"
    },
    {
      iconHtml: `<i class="fas fa-2x fa-cart-plus"></i>`,
      itemTitle: "Quản lý kiểm kho",
      routerLink: "inventory-management"

    },
  ]
  constructor(
    private router: Router,
    private accountService: AccountService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }

  onRedirect(routerLink: string) {
    this.router.navigateByUrl('/admin/' + routerLink);
  }

  onLogout() {
   this.accountService.Logout();
  }
}
