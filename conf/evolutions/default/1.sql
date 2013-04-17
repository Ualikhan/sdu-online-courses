# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table announcement (
  id                        bigint not null,
  title                     varchar(255),
  content                   TEXT,
  created_date              timestamp,
  course_id                 bigint,
  constraint pk_announcement primary key (id))
;

create table course (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               TEXT,
  owner_email               varchar(255),
  constraint pk_course primary key (id))
;

create table course_information (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   TEXT,
  course_id                 bigint,
  constraint pk_course_information primary key (id))
;

create table lecture (
  id                        bigint not null,
  title                     varchar(255),
  content                   TEXT,
  course_id                 bigint,
  constraint pk_lecture primary key (id))
;

create table module (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_module primary key (id))
;

create table role (
  id                        bigint not null,
  name                      varchar(13),
  constraint ck_role_name check (name in ('Administrator','Tutor','Student')),
  constraint pk_role primary key (id))
;

create table user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  position                  varchar(255),
  company                   varchar(255),
  photo                     varchar(255),
  role_id                   bigint,
  constraint pk_user primary key (email))
;

create table video_resource (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  file_path                 TEXT,
  file_url                  TEXT,
  resource_type             varchar(10),
  lecture_id                bigint,
  constraint ck_video_resource_resource_type check (resource_type in ('VIDEO','SLIDE','BOOK','AUDIO','TRANSCRIPT')),
  constraint pk_video_resource primary key (id))
;


create table role_module (
  role_id                        bigint not null,
  module_id                      bigint not null,
  constraint pk_role_module primary key (role_id, module_id))
;

create table user_course (
  user_email                     varchar(255) not null,
  course_id                      bigint not null,
  constraint pk_user_course primary key (user_email, course_id))
;
create sequence announcement_seq;

create sequence lecture_seq;

create sequence module_seq;

create sequence role_seq;

create sequence user_seq;

alter table announcement add constraint fk_announcement_course_1 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_announcement_course_1 on announcement (course_id);
alter table course add constraint fk_course_owner_2 foreign key (owner_email) references user (email) on delete restrict on update restrict;
create index ix_course_owner_2 on course (owner_email);
alter table course_information add constraint fk_course_information_course_3 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_course_information_course_3 on course_information (course_id);
alter table lecture add constraint fk_lecture_course_4 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_lecture_course_4 on lecture (course_id);
alter table user add constraint fk_user_role_5 foreign key (role_id) references role (id) on delete restrict on update restrict;
create index ix_user_role_5 on user (role_id);
alter table video_resource add constraint fk_video_resource_lecture_6 foreign key (lecture_id) references lecture (id) on delete restrict on update restrict;
create index ix_video_resource_lecture_6 on video_resource (lecture_id);



alter table role_module add constraint fk_role_module_role_01 foreign key (role_id) references role (id) on delete restrict on update restrict;

alter table role_module add constraint fk_role_module_module_02 foreign key (module_id) references module (id) on delete restrict on update restrict;

alter table user_course add constraint fk_user_course_user_01 foreign key (user_email) references user (email) on delete restrict on update restrict;

alter table user_course add constraint fk_user_course_course_02 foreign key (course_id) references course (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists announcement;

drop table if exists course;

drop table if exists course_information;

drop table if exists lecture;

drop table if exists module;

drop table if exists role;

drop table if exists role_module;

drop table if exists user;

drop table if exists user_course;

drop table if exists video_resource;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists announcement_seq;

drop sequence if exists lecture_seq;

drop sequence if exists module_seq;

drop sequence if exists role_seq;

drop sequence if exists user_seq;

