import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {FormControl} from "@angular/forms";
import {Observable} from "rxjs";
import {BookQuery} from "../../../../../../states/book-store/book.query";
import {map, startWith, tap} from "rxjs/operators";
import {BookService} from "../../../../../../states/book-store/book.service";
import {ApiBookService} from "../../../../../../API/api-book.service";

@Component({
  selector: 'app-create-inventory',
  templateUrl: './create-inventory.component.html',
  styleUrls: ['./create-inventory.component.scss']
})
export class CreateInventoryComponent implements OnInit {
  all_books = [];
  book_control = new FormControl();
  book_options: string[] = [];
  book_filtered_options: Observable<string[]>;
  book_item: any;

  constructor(
      private bookQuery: BookQuery,
      private bookService: BookService,
      private bookApi: ApiBookService,
      private router: Router,
  ) { }

  async ngOnInit() {
    this.all_books = await this.bookApi.GetBooks().then(res => res.items);
    this.all_books.forEach(book => {
      this.book_options.push(book.id.toString());
    })
    this.book_filtered_options = this.book_control.valueChanges.pipe(
        startWith(''),
        map(value => this._bookFilter(value)),
        tap(() => {
          if(parseInt(this.book_control.value)){
            this.book_item = this.all_books.find(book => book.id == parseInt(this.book_control.value))
          }
        })
    );
  }

  CreateInventory() {

  }

  goBack() {
    this.router.navigateByUrl('admin/book-management/book-list')
  }

  private _bookFilter(value: string): string[] {
    return this.book_options.filter(book => book.toLowerCase().indexOf(value) === 0);
  }
}
