import { IsString, IsNumber, IsOptional, IsUUID } from 'class-validator';

export class CreateBookDto {
  @IsString()
  title: string;

  @IsString()
  isbn: string;

  @IsString()
  @IsOptional()
  description?: string;

  @IsNumber()
  publicationYear: number;

  @IsUUID()
  authorId: string;
}

export class UpdateBookDto {
  @IsString()
  @IsOptional()
  title?: string;

  @IsString()
  @IsOptional()
  isbn?: string;

  @IsString()
  @IsOptional()
  description?: string;

  @IsNumber()
  @IsOptional()
  publicationYear?: number;

  @IsUUID()
  @IsOptional()
  authorId?: string;
} 