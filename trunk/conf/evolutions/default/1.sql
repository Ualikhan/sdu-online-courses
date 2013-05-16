# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table announcement (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   TEXT,
  created_date              datetime,
  course_id                 bigint,
  constraint pk_announcement primary key (id))
;

create table answer (
  id                        bigint auto_increment not null,
  answer_content            TEXT,
  is_true_answer            tinyint(1) default 0,
  question_id               bigint,
  constraint pk_answer primary key (id))
;

create table assignment (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  description               TEXT,
  action_items              TEXT,
  start_date                datetime,
  deadline                  datetime,
  submission_form_id        bigint,
  course_id                 bigint,
  constraint pk_assignment primary key (id))
;

create table course (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               TEXT,
  owner_email               varchar(40),
  constraint pk_course primary key (id))
;

create table course_description (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   TEXT,
  course_id                 bigint,
  constraint pk_course_description primary key (id))
;

create table course_information (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   TEXT,
  course_id                 bigint,
  constraint pk_course_information primary key (id))
;

create table lecture (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   TEXT,
  key_concepts              TEXT,
  reading                   TEXT,
  assignment                TEXT,
  additional_resources      TEXT,
  course_id                 bigint,
  constraint pk_lecture primary key (id))
;

create table lecture_resource (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  file_url                  TEXT,
  resource_type             ENUM('VIDEO','SLIDE','BOOK','AUDIO','TRANSCRIPT'),
  lecture_id                bigint,
  constraint ck_lecture_resource_resource_type check (resource_type in ('VIDEO','SLIDE','BOOK','AUDIO','TRANSCRIPT')),
  constraint pk_lecture_resource primary key (id))
;

create table module (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_module primary key (id))
;

create table question (
  id                        bigint auto_increment not null,
  question_content          TEXT,
  answer_type               ENUM('QA','SCT','MCT'),
  num_of_answers            integer,
  num_of_right_answers      integer,
  submission_form_id        bigint,
  constraint ck_question_answer_type check (answer_type in ('QA','SCT','MCT')),
  constraint pk_question primary key (id))
;

create table role (
  id                        bigint auto_increment not null,
  name                      ENUM('Administrator','Tutor','Student'),
  constraint ck_role_name check (name in ('Administrator','Tutor','Student')),
  constraint pk_role primary key (id))
;

create table submission_form (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  constraint pk_submission_form primary key (id))
;

create table submission_item (
  name                      varchar(255),
  value                     varchar(255),
  submission_form_id        bigint)
;

create table user (
  email                     varchar(40) not null,
  name                      varchar(255),
  password                  varchar(255),
  position                  varchar(255),
  company                   varchar(255),
  photo                     varchar(255),
  role_id                   bigint,
  constraint pk_user primary key (email))
;


create table role_module (
  role_id                        bigint not null,
  module_id                      bigint not null,
  constraint pk_role_module primary key (role_id, module_id))
;

create table user_course (
  user_email                     varchar(40) not null,
  course_id                      bigint not null,
  constraint pk_user_course primary key (user_email, course_id))
;
alter table announcement add constraint fk_announcement_course_1 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_announcement_course_1 on announcement (course_id);
alter table answer add constraint fk_answer_question_2 foreign key (question_id) references question (id) on delete restrict on update restrict;
create index ix_answer_question_2 on answer (question_id);
alter table assignment add constraint fk_assignment_submissionForm_3 foreign key (submission_form_id) references submission_form (id) on delete restrict on update restrict;
create index ix_assignment_submissionForm_3 on assignment (submission_form_id);
alter table assignment add constraint fk_assignment_course_4 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_assignment_course_4 on assignment (course_id);
alter table course add constraint fk_course_owner_5 foreign key (owner_email) references user (email) on delete restrict on update restrict;
create index ix_course_owner_5 on course (owner_email);
alter table course_description add constraint fk_course_description_course_6 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_course_description_course_6 on course_description (course_id);
alter table course_information add constraint fk_course_information_course_7 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_course_information_course_7 on course_information (course_id);
alter table lecture add constraint fk_lecture_course_8 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_lecture_course_8 on lecture (course_id);
alter table lecture_resource add constraint fk_lecture_resource_lecture_9 foreign key (lecture_id) references lecture (id) on delete restrict on update restrict;
create index ix_lecture_resource_lecture_9 on lecture_resource (lecture_id);
alter table question add constraint fk_question_submissionForm_10 foreign key (submission_form_id) references submission_form (id) on delete restrict on update restrict;
create index ix_question_submissionForm_10 on question (submission_form_id);
alter table submission_item add constraint fk_submission_item_submissionForm_11 foreign key (submission_form_id) references submission_form (id) on delete restrict on update restrict;
create index ix_submission_item_submissionForm_11 on submission_item (submission_form_id);
alter table user add constraint fk_user_role_12 foreign key (role_id) references role (id) on delete restrict on update restrict;
create index ix_user_role_12 on user (role_id);



alter table role_module add constraint fk_role_module_role_01 foreign key (role_id) references role (id) on delete restrict on update restrict;

alter table role_module add constraint fk_role_module_module_02 foreign key (module_id) references module (id) on delete restrict on update restrict;

alter table user_course add constraint fk_user_course_user_01 foreign key (user_email) references user (email) on delete restrict on update restrict;

alter table user_course add constraint fk_user_course_course_02 foreign key (course_id) references course (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table announcement;

drop table answer;

drop table assignment;

drop table course;

drop table course_description;

drop table course_information;

drop table lecture;

drop table lecture_resource;

drop table module;

drop table question;

drop table role;

drop table role_module;

drop table submission_form;

drop table submission_item;

drop table user;

drop table user_course;

SET FOREIGN_KEY_CHECKS=1;

