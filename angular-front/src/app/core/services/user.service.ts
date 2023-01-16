import { EventEmitter, Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { AuthorizationService } from './authorization.service';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UserService {
  private userId?: number;
  private authorizationService: AuthorizationService;
  private http: HttpClient;
  private baseUrl: string = 'http://localhost:6060/';
  loyaltyProgram = new EventEmitter<{ isInLoyaltyProgram: boolean }>();

  constructor(authorizationService: AuthorizationService, http: HttpClient) {
    this.http = http;
    this.authorizationService = authorizationService;
    if (this.authorizationService.isLoggedIn()) {
      this.userId = authorizationService.getUserId();
    }
    this.authorizationService.isLoggedInChanged.subscribe(({ loggedIn }) => {
      if (loggedIn) {
        this.userId = this.authorizationService.getUserId();
      } else {
        this.clearUser();
      }
    });
  }

  verifyLoyaltyProgram(): Observable<any> {
    return this.http.get(this.baseUrl + 'checkLoyaltyProgram/' + this.userId).pipe(
      map((res: any) => {
        return { isInLoyaltyProgram: res.participant, bookcoins: res.bookcoins };
      })
    );
  }

  getBookcoins() {
    return 30;
  }

  joinLoyaltyProgram() {
    const headers = { 'content-type': 'application/json' };
    if (this.userId) {
      this.http
        .post(this.baseUrl + 'joinLoyaltyProgram', JSON.stringify({ id: this.userId }), {
          headers: headers,
        })
        .subscribe((res) => {
          console.log(res);
          if (res === 'OK') {
            this.loyaltyProgram.emit({ isInLoyaltyProgram: true });
          }
        });
    }
  }

  getUserId() {
    return this.userId;
  }

  clearUser() {
    this.userId = 0;
    this.loyaltyProgram.emit({ isInLoyaltyProgram: false });
  }
}
