import { HttpService } from 'src/app/services/http.service';
import { ModalController } from './../../../../../../core/modal-controller/modal-controller.service';
import { BookStore } from './../../../../../../states/book-store/book.store';
import { ApiCategoryService } from './../../../../../../API/api-book-category.service';
import { BookService } from 'src/app/states/book-store/book.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { BookQuery } from 'src/app/states/book-store/book.query';
import { AddAuthorModalComponent } from '../add-author-modal/add-author-modal.component';
import { AddCategoryModalComponent } from '../add-category-modal/add-category-modal.component';
import { AddSupplierModalComponent } from '../add-supplier-modal/add-supplier-modal.component';
import { ApiAppService } from 'src/app/API/api-app.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.scss']
})
export class CreateBookComponent implements OnInit {
  filter = {
    page : 1,
    per_page : 1000
  }

  createBookForm = this.fb.group({
    book_name: [''],
    author:[''],
    category: [''],
    page_number: [''],
    retail_price: [''],
    old_amount: [''],
    description: [''],
    note: [''],
    image: ''
  });

  baseURL = '';

  authors$ = this.bookQuery.authors$;
  categories$ = this.bookQuery.categories$;
  suppliers$ = this.bookQuery.suppliers$;

  constructor(
    private fb : FormBuilder,
    private router: Router,
    private bookService: BookService,
    private bookStore: BookStore,
    private bookQuery: BookQuery,
    private modalController: ModalController,
    private apiAppService: ApiAppService,
    private http: HttpClient
    ) {
      this.baseURL = this.apiAppService.baseURL;
     }

  async ngOnInit() {
    await this.SetupData()
  }
  async onCreateUser() {
    // const newReader = {...this.reader};
    // const res = await this.readerService.createReader(newReader);
    // if(res.success) {
    //   toastr.success("Bạn đã tạo mới đọc giả thành công!", "Đăng ký thành công");
    //   this.router.navigateByUrl('/admin/user-management/user-list');
    // } else {
    //   toastr.error("Vui lòng thực hiện lại thao tác!", "Đăng ký thất bại");
    // }
  }

  async SetupData() {
    await this.bookService.GetAuthors(this.filter);
    await this.bookService.GetCategories(this.filter);
    await this.bookService.GetSuppliers(this.filter);
  }

  ResetDataForm() {
    this.createBookForm.patchValue({
      'book_name': '',
      'author': '',
      'category': '',
      'page_number': '',
      'cost_price': '',
      'retail_price': '',
      'discount': '',
      'description': '',
      'old_amount': '',
      'new_amount':'',
      'note': '',
    });
  }

  async CreateBook() {
    let book_data = this.createBookForm.value;
    if(!book_data.book_name || !book_data.author || !book_data.category) {
      toastr.error("Tạo mới sách thất bại.", "Vui lòng nhập đầy đủ thông tin sách.")
      return;
    }
    try {
      let created_book = await this.bookService.CreateBook(book_data)
      this.router.navigateByUrl(`/admin/book-management/book-list`);
      toastr.success("Tạo mới sách thành công.");
    } catch(e) {
      toastr.error("Tạo mới sách thất bại", e.msg || e.message)
    }
  }

  goBack() {
    this.router.navigateByUrl('admin/book-management/book-list')
  }

}
