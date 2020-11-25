import { Injectable } from '@nestjs/common';
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

  async findByNameLine(name_line: string):Promise<Ligne>{
    return this.lignes.find(lignes=>lignes.name_line == name_line);
  }

 async findByShortName(shortname_groupoflines: string): Promise<Ligne> {
    return this.lignes.find(lignes => lignes.shortname_groupoflines == shortname_groupoflines);
  }

  async findByTransportMode(transportmode: string): Promise<Ligne[]> {
    return this.lignes.filter(lignes => lignes.transportmode == transportmode);
  }

  async delete(shortname_groupoflines: string): Promise<void> {
     this.lignes = getLignes(this.records).filter(ligne => ligne.shortname_groupoflines !== shortname_groupoflines);
  }

  // async makeFavorite(name_line: string): Promise<Ligne>{
  //   const results = this.findByNameLine(name_line);
  //   return results;
  // }
}
