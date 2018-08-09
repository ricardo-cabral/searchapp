import {Component} from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { map, flatMap, toArray} from 'rxjs/operators';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: [ './search.component.css']
})

export class SearchComponent {

  topicList: string[];

  constructor(private http: HttpClient) {}

   getTopicList() {
    this.http.get<any[]>('http://localhost:8080/topics?searchString=Topic').pipe(
     flatMap(topics => topics),
       map(topic => topic.name),
       toArray()
   ).subscribe(topics => this.topicList = topics);
   }
}
