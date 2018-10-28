import { Component, OnInit } from '@angular/core';
import {Service} from '../service';
import {AdminService} from '../admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  constructor(public adminService: AdminService) {


  }

  ngOnInit() {
      this.adminService.connect();
  }

}
