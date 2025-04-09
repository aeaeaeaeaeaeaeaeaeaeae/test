import { Entity, PrimaryGeneratedColumn, Column, ManyToOne, OneToMany, CreateDateColumn, UpdateDateColumn } from 'typeorm';
import { Author } from './author.entity';
import { BookCopy } from './book-copy.entity';

@Entity('books')
export class Book {
  @PrimaryGeneratedColumn('uuid')
  id: string;

  @Column()
  title: string;

  @Column()
  isbn: string;

  @Column({ type: 'text', nullable: true })
  description: string;

  @Column()
  publicationYear: number;

  @ManyToOne(() => Author, author => author.books)
  author: Author;

  @OneToMany(() => BookCopy, bookCopy => bookCopy.book)
  copies: BookCopy[];

  @CreateDateColumn()
  createdAt: Date;

  @UpdateDateColumn()
  updatedAt: Date;
} 