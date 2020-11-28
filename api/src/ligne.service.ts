import { Injectable} from '@nestjs/common';
import { record, hits, getLignes, getRecords, Ligne } from './Ligne';

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

  makeFavorite(name_line: string): void{
    this.lignes.find(lignes=>lignes.name_line == name_line).favorite = !this.lignes.find(lignes=>lignes.name_line == name_line).favorite;
  }

  // findFavorite(): Ligne[]{
  //   return this.lignes.filter(lignes => lignes.favorite == true);
  // }
}
