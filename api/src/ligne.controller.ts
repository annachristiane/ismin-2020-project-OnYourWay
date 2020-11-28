import { Controller, Get, Post, Body, Param, Delete, Put, Query } from '@nestjs/common';
import { LigneService } from './ligne.service';
import { hits, Ligne} from './Ligne';

@Controller('/lignes')
export class LigneController {
  constructor(private readonly ligneService: LigneService) {}

  @Post()
  async create(@Body() hits: hits): Promise<void> {
    return await this.ligneService.create(hits);
  }

  @Get(':name_line')
  async findByNameLine(@Param('name_line') name_line):Promise<Ligne>{
    return this.ligneService.findByNameLine(name_line);
  }

  @Get()
  async findByTransportMode(@Query('transportmode') transportmode): Promise<Ligne[]> {
    if(transportmode){
      return this.ligneService.findByTransportMode(transportmode);
    }
    else
      return this.ligneService.findAll();
  }

  @Delete(':shortname_groupoflines')
  async delete(@Param('shortname_groupoflines') shortname_groupoflines) : Promise<void> {
    return this.ligneService.delete(shortname_groupoflines);
  }

  @Put(':name_line')
  makeFavorite(@Param('name_line') name_line:string): void{
    this.ligneService.makeFavorite(name_line);
  }

  // @Get(':favorite')
  // findFavorite():Ligne[]{
  //   return this.ligneService.findFavorite();
  // }
}