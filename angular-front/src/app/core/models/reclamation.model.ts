import { Delivery } from './delivery.model';

export interface ReclamationPosition {
  productId: number;
  amount: number;
  reason: string;
}

export interface Reclamation {
  reclamationPositions: ReclamationPosition[];
  orderNumber: number;
  userId: number;
  delivery: Delivery;
}
