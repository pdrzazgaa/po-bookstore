import { EventEmitter, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ParcelMachine } from '../models';

@Injectable()
export class ParcelMachineService {
  private parcelMachines: ParcelMachine[] = [];
  private http: HttpClient;
  private baseUrl: string = 'http://localhost:6060/APMs';
  parcelsChanged = new EventEmitter<ParcelMachine[]>();

  constructor(http: HttpClient) {
    this.http = http;
  }

  getParcelMachines() {
    if (!this.parcelMachines.length) {
      const parcels: ParcelMachine[] = [];
      this.fetchParcelMachines().subscribe(
        (res: { id: number; code: string; address: string }[]) => {
          res.forEach(({ code, address }) => {
            parcels.push({ code, address });
          });
          this.parcelMachines = parcels;
          this.parcelsChanged.emit(parcels);
        }
      );
    }
    return this.parcelMachines;
  }

  getParcelMachinesFiltered(input: string) {
    if (!this.parcelMachines.length) {
      this.getParcelMachines();
    }

    const substr = input.toLowerCase();
    return [
      ...this.parcelMachines.filter((parcel) => {
        return (
          parcel.code.toLowerCase().includes(substr) ||
          parcel.address.toLowerCase().includes(substr)
        );
      }),
    ];
  }

  private fetchParcelMachines(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
}
