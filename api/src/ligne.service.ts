import { Injectable, Inject } from '@nestjs/common';
import { getLignes, getRecords, Ligne } from './Ligne';
import { record } from './Ligne';
import { hits } from './Ligne';

@Injectable()
export class LigneService {
  private lignes: Ligne[] = [];
  private records: record[] = [];
  private hits: hits;

  findAll(): Ligne[] {
    return this.lignes;
  }

  async create(hits: hits): Promise<void> {
    this.hits = hits;
    this.records = getRecords(this.hits);
    this.lignes = getLignes(this.records);
  }

 async findById(id_line: string): Promise<Ligne> {
    return this.lignes.find(lignes => lignes.id_line == id_line);
  }

  async findByTransportMode(transportmode: string): Promise<Ligne[]> {
    return this.lignes.filter(lignes => lignes.transportmode == transportmode);
  }

  async delete(id_line: string): Promise<void> {
    //delete this.books[this.books.findIndex(book => book.title == title)];
    // this.records = getRecords(this.hits).filter(ligne => ligne.recordid !== id_line);
     this.lignes = getLignes(this.records).filter(ligne => ligne.id_line !== id_line)
  //  return this.BookModel.findOneAndDelete({title: title}).exec();
  }
}
