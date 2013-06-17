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
  is_true_answer            integer,
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
  assignment_weight         integer,
  submission_form_created   tinyint(1) default 0,
  course_id                 bigint,
  constraint pk_assignment primary key (id))
;

create table conversation (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  description               TEXT,
  sended_date               datetime,
  from_user_email           varchar(40),
  to_user_email             varchar(40),
  conversation_type         ENUM('THREAD','REPLY'),
  replied_to_id             bigint,
  course_id                 bigint,
  constraint ck_conversation_conversation_type check (conversation_type in ('THREAD','REPLY')),
  constraint pk_conversation primary key (id))
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

create table forum_type (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_forum_type primary key (id))
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

create table post (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  description               TEXT,
  posted_date               datetime,
  votes                     integer,
  views                     bigint,
  author_email              varchar(40),
  forum_type_id             bigint,
  post_type                 ENUM('THREAD','REPLY'),
  replied_to_id             bigint,
  course_id                 bigint,
  constraint ck_post_post_type check (post_type in ('THREAD','REPLY')),
  constraint pk_post primary key (id))
;

create table question (
  id                        bigint auto_increment not null,
  question_content          TEXT,
  answer_type               ENUM('QE','QA','SCT','MCT'),
  num_of_answers            integer,
  num_of_right_answers      integer,
  question_weight           integer,
  assignment_id             bigint,
  constraint ck_question_answer_type check (answer_type in ('QE','QA','SCT','MCT')),
  constraint pk_question primary key (id))
;

create table role (
  id                        bigint auto_increment not null,
  name                      ENUM('Administrator','Tutor','Student'),
  constraint ck_role_name check (name in ('Administrator','Tutor','Student')),
  constraint pk_role primary key (id))
;

create table student_submission (
  id                        bigint auto_increment not null,
  student_email             varchar(40),
  grade                     integer,
  submission_type           ENUM('SAVED','SUBMITTED','CHECKED'),
  assignment_id             bigint,
  created_date              datetime,
  constraint ck_student_submission_submission_type check (submission_type in ('SAVED','SUBMITTED','CHECKED')),
  constraint pk_student_submission primary key (id))
;

create table submission_item (
  id                        bigint auto_increment not null,
  question_id               bigint,
  answer                    TEXT,
  grade                     integer,
  student_submission_id     bigint,
  constraint pk_submission_item primary key (id))
;

create table user (
  email                     varchar(40) not null,
  password                  varchar(255),
  name                      varchar(255),
  age                       integer,
  gender                    ENUM('Male','Female'),
  address                   varchar(255),
  photo                     varchar(255),
  position                  varchar(255),
  company                   varchar(255),
  registered_date           datetime,
  last_active               datetime,
  active                    tinyint(1) default 0,
  role_id                   bigint,
  constraint ck_user_gender check (gender in ('Male','Female')),
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
alter table assignment add constraint fk_assignment_course_3 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_assignment_course_3 on assignment (course_id);
alter table conversation add constraint fk_conversation_fromUser_4 foreign key (from_user_email) references user (email) on delete restrict on update restrict;
create index ix_conversation_fromUser_4 on conversation (from_user_email);
alter table conversation add constraint fk_conversation_toUser_5 foreign key (to_user_email) references user (email) on delete restrict on update restrict;
create index ix_conversation_toUser_5 on conversation (to_user_email);
alter table conversation add constraint fk_conversation_repliedTo_6 foreign key (replied_to_id) references conversation (id) on delete restrict on update restrict;
create index ix_conversation_repliedTo_6 on conversation (replied_to_id);
alter table conversation add constraint fk_conversation_course_7 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_conversation_course_7 on conversation (course_id);
alter table course add constraint fk_course_owner_8 foreign key (owner_email) references user (email) on delete restrict on update restrict;
create index ix_course_owner_8 on course (owner_email);
alter table course_description add constraint fk_course_description_course_9 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_course_description_course_9 on course_description (course_id);
alter table course_information add constraint fk_course_information_course_10 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_course_information_course_10 on course_information (course_id);
alter table lecture add constraint fk_lecture_course_11 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_lecture_course_11 on lecture (course_id);
alter table lecture_resource add constraint fk_lecture_resource_lecture_12 foreign key (lecture_id) references lecture (id) on delete restrict on update restrict;
create index ix_lecture_resource_lecture_12 on lecture_resource (lecture_id);
alter table post add constraint fk_post_author_13 foreign key (author_email) references user (email) on delete restrict on update restrict;
create index ix_post_author_13 on post (author_email);
alter table post add constraint fk_post_forumType_14 foreign key (forum_type_id) references forum_type (id) on delete restrict on update restrict;
create index ix_post_forumType_14 on post (forum_type_id);
alter table post add constraint fk_post_repliedTo_15 foreign key (replied_to_id) references post (id) on delete restrict on update restrict;
create index ix_post_repliedTo_15 on post (replied_to_id);
alter table post add constraint fk_post_course_16 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_post_course_16 on post (course_id);
alter table question add constraint fk_question_assignment_17 foreign key (assignment_id) references assignment (id) on delete restrict on update restrict;
create index ix_question_assignment_17 on question (assignment_id);
alter table student_submission add constraint fk_student_submission_student_18 foreign key (student_email) references user (email) on delete restrict on update restrict;
create index ix_student_submission_student_18 on student_submission (student_email);
alter table student_submission add constraint fk_student_submission_assignment_19 foreign key (assignment_id) references assignment (id) on delete restrict on update restrict;
create index ix_student_submission_assignment_19 on student_submission (assignment_id);
alter table submission_item add constraint fk_submission_item_question_20 foreign key (question_id) references question (id) on delete restrict on update restrict;
create index ix_submission_item_question_20 on submission_item (question_id);
alter table submission_item add constraint fk_submission_item_studentSubmission_21 foreign key (student_submission_id) references student_submission (id) on delete restrict on update restrict;
create index ix_submission_item_studentSubmission_21 on submission_item (student_submission_id);
alter table user add constraint fk_user_role_22 foreign key (role_id) references role (id) on delete restrict on update restrict;
create index ix_user_role_22 on user (role_id);



alter table role_module add constraint fk_role_module_role_01 foreign key (role_id) references role (id) on delete restrict on update restrict;

alter table role_module add constraint fk_role_module_module_02 foreign key (module_id) references module (id) on delete restrict on update restrict;

alter table user_course add constraint fk_user_course_user_01 foreign key (user_email) references user (email) on delete restrict on update restrict;

alter table user_course add constraint fk_user_course_course_02 foreign key (course_id) references course (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table announcement;

drop table answer;

drop table assignment;

drop table conversation;

drop table course;

drop table course_description;

drop table course_information;

drop table forum_type;

drop table lecture;

drop table lecture_resource;

drop table module;

drop table post;

drop table question;

drop table role;

drop table role_module;

drop table student_submission;

drop table submission_item;

drop table user;

drop table user_course;

SET FOREIGN_KEY_CHECKS=1;

