import { Injectable } from '@angular/core';
import { ParcelMachine } from '../models';

@Injectable()
export class ParcelMachineService {
  private parcelMachines: ParcelMachine[] = [];

  getParcelMachines() {
    this.parcelMachines = [
      { code: 'WRO12B', address: 'Curie-Skłodowskiej 64' },
      { code: 'WRO24C', address: 'Norwida 5' },
      { code: 'WRO34D', address: 'Krakowska 5' },
      { code: 'WRO12F', address: 'Tadeusza Olszewskiego 17' },
      { code: 'WRO98R', address: 'Drzymały 89' },
      { code: 'WRO111', address: 'Tadeusza Kościuszki 123' },
      { code: 'WRO222', address: 'Powstańców Wielkopolskich 32' },
      { code: 'WRO12F', address: 'Koszarowa 1' },
      { code: 'WRO13B', address: 'Pauliny Drzazgi 1' },
      { code: 'WRO33B', address: 'Tramwajowa 19' },
    ];
    return [...this.parcelMachines];
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
}
