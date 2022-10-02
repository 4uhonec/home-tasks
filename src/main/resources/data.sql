-- INSERT workers
insert into worker (worker_id, name, email) values (111, 'John', 'warton@gmail.com');
insert into worker (worker_id, name, email) values (222, 'Mike', 'lanister@gmail.com');
insert into worker (worker_id, name, email) values (333, 'Steve', 'Reeves@gmail.com');
insert into worker (worker_id, name, email) values (444, 'Ronald', 'connor@gmail.com');
insert into worker (worker_id, name, email) values (555, 'Jim', 'Sal@gmail.com');
insert into worker (worker_id, name, email) values (666, 'Peter', 'henley@gmail.com');
insert into worker (worker_id, name, email) values (777, 'Richard', 'carson@gmail.com');
insert into worker (worker_id, name, email) values (888, 'Honor', 'miles@gmail.com');
insert into worker (worker_id, name, email) values (999, 'Tony', 'roggers@gmail.com');

-- INSERT tasks
insert into task (task_id, name, status, urgency, description) values (1000, 'Large Production Deploy', 'NOTSTARTED', 'CHILL', 'This requires all hands on deck for the final deployment of the software into production');
insert into task (task_id, name, status, urgency, description) values (1001, 'New Employee Budget',  'COMPLETED', 'MODERATE', 'Decide on a new employee bonus budget for the year and figureout who will be promoted');
insert into task (task_id, name, status, urgency, description) values (1002, 'Office Reconstruction', 'INPROGRESS', 'URGENT', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed');
insert into task (task_id, name, status, urgency, description) values (1003, 'Improve Intranet Security', 'INPROGRESS', 'MODERATE', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');

-- INSERT task_worker relation
insert into task_worker (worker_id, task_id) values (111,1000);
insert into task_worker (worker_id, task_id) values (111,1001);
insert into task_worker (worker_id, task_id) values (111,1002);
insert into task_worker (worker_id, task_id) values (333,1000);
insert into task_worker (worker_id, task_id) values (666,1002);
insert into task_worker (worker_id, task_id) values (666,1003);