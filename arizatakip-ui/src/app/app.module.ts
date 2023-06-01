import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {MegaMenuModule} from "primeng/megamenu";
import {ChipsModule} from "primeng/chips";
import {PaginatorModule} from "primeng/paginator";
import {HeaderComponent} from "./core/views/main/header/header.component";
import {PanelModule} from "primeng/panel";
import {FooterComponent} from "./core/views/main/footer/footer.component";
import {NavbarComponent} from "./core/views/main/navbar/navbar.component";
import {TieredMenuModule} from "primeng/tieredmenu";
import { MainScreeenComponent } from './core/views/main/main-screeen/main-screeen.component';
import { AppRoutingModule } from './app-routing.module';
import { NotFoundComponent } from './core/views/not-found/not-found.component';
import {TableModule} from "primeng/table";
import {SplitterModule} from "primeng/splitter";
import {ButtonModule} from "primeng/button";
import { FaultComponent } from './core/views/fault/fault.component';
import {CalendarModule} from "primeng/calendar";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {GalleriaModule} from "primeng/galleria";

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        FooterComponent,
        NavbarComponent,
        MainScreeenComponent,
        NotFoundComponent,
        FaultComponent,

    ],
    imports: [
        BrowserModule,
        MegaMenuModule,
        ChipsModule,
        PaginatorModule,
        PanelModule,
        TieredMenuModule,
        AppRoutingModule,
        TableModule,
        SplitterModule,
        ButtonModule,
        CalendarModule,
        BrowserAnimationsModule,
        GalleriaModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
