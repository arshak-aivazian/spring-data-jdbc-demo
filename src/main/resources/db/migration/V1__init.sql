create table categories (
    id bigserial primary key,
    title varchar(255)
);

create table authors (
    id bigserial primary key,
    full_name varchar(255)
);

create table books (
    id bigserial primary key,
    title varchar(255),
    genre varchar(255),
    author_id bigint,
    foreign key (author_id) references authors (id)
);

create table books_details (
    id bigserial primary key,
    book_id bigint,
    description varchar(255),
    foreign key (book_id) references books (id)
);

create table reviews
(
    id         bigserial primary key,
    book_id    bigint,
    rate       numeric CHECK (rate >= 0 and rate <= 10),
    text       varchar(255),
    created_by varchar(255),
    created_at timestamp,
    foreign key (book_id) references books (id)
);

insert into authors (full_name) values ('Толкиен'), ('Роулинг'), ('Сандерсон'), ('Азимов');

insert into books (title, author_id, genre) values
  ('Властелин колец: Братство кольца', 1, 'FANTASY'),
  ('Властелин колец: Две крепости', 1, 'FANTASY'),
  ('Властелин колец: Возвращение короля', 1, 'FANTASY'),
  ('Сильмариллион', 1, 'FANTASY'),
  ('Хоббит: туда и обратно', 1, 'FANTASY'),
  ('Гарри Поттер и Философский камень', 2, 'FANTASY'),
  ('Рожденный туманом: Пепел и сталь', 3, 'FANTASY'),
  ('Рожденный туманом: Источник вознесения', 3, 'FANTASY'),
  ('Рожденный туманом: Герой веков', 3, 'FANTASY'),
  ('Архив Буресвета: Путь королей', 3, 'FANTASY'),
  ('Академия', 4, 'SCIFI');

insert into books_details (book_id, description) values
  (1, 'Книга про Властелина колец'),
  (2, 'Книга про Гарри Поттера'),
  (3, 'Книга про Рожденного туманом'),
  (4, 'Книга про Рожденного туманом'),
  (5, 'Книга про Рожденного туманом'),
  (6, 'Книга про Архив Буресвета'),
  (7, 'Книга про Академию. Основная трилогия');

insert into reviews (book_id, rate, text, created_by, created_at) values
    (1, 7, 'test', 'arshak', '2023-12-12 00:00:00'),
    (1, 9, 'test', 'arshak', '2023-10-10 00:00:00'),
    (2, 10, 'test', 'arshak', '2023-10-10 00:00:00'),
    (2, 1, 'test', 'arshak', '2023-12-12 00:00:00'),
    (3, 10, 'test', 'arshak', '2023-12-12 00:00:00'),
    (4, 9, 'test', 'arshak', '2023-12-12 00:00:00'),
    (5, 8, 'test', 'arshak', '2023-12-12 00:00:00'),
    (6, 7, 'test', 'arshak', '2023-12-12 00:00:00'),
    (7, 6, 'test', 'arshak', '2023-12-12 00:00:00'),
    (8, 5, 'test', 'arshak', '2023-12-12 00:00:00'),
    (9, 4, 'test', 'arshak', '2023-12-12 00:00:00'),
    (10, 3, 'test', 'arshak', '2023-12-12 00:00:00'),
    (11, 3, 'test', 'arshak', '2023-12-12 00:00:00');