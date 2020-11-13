import { NestFactory } from '@nestjs/core';
import { LigneModule } from './ligne.module';

async function bootstrap() {
  const app = await NestFactory.create(LigneModule);
  await app.listen(8080);
}
bootstrap();
