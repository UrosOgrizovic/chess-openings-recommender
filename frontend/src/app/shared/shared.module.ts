import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [],
  exports: [],
  imports: [
    CommonModule,
    ToastrModule.forRoot({ positionClass: 'inline' }),
    FormsModule
  ],
  entryComponents: []
})
export class SharedModule { }
