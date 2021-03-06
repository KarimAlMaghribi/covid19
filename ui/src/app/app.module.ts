import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // this is needed!
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule, ActivatedRoute } from '@angular/router';
import { AppRoutingModule } from './app.routing';
import { SectionsModule } from './sections/sections.module';
import { ComponentsModule } from './components/components.module';
import { ExamplesModule } from './examples/examples.module';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './shared/navbar/navbar.component';

import { PresentationModule } from './presentation/presentation.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent
    ],
    imports: [
        BrowserAnimationsModule,
        NgbModule,
        FormsModule,
        RouterModule,
        AppRoutingModule,
        PresentationModule,
        SectionsModule,
        ComponentsModule,
        ExamplesModule,
        BrowserModule,
        HttpClientModule,
        CommonModule,
        ActivatedRoute
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
