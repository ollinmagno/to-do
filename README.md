# API REST - TO-DO

● Usuário pode adicionar uma tarefa;
<br><br>

@PutMapping(value = "/{id}"); <br>
● Usuário pode editar uma tarefa                        
<br><br>

@PutMapping(value = "marcarRealizada/{id}"); <br>
● Usuário pode marcar uma tarefa como realizada        
<br><br>

@DeleteMapping(value = "/{id}") <br>
● Usuário pode remover uma tarefa                       
<br><br>

@GetMapping(value = "/tarefasRealizadas") <br>
● Usuário pode ver uma lista com todos as tarefas realizadas; 
<br><br>

@GetMapping(value = "/tarefasAtivas") <br>
● Usuário pode ver uma lista com todos as tarefas ativas; 
<br><br>

● Usuário pode ver a data que foi criada a tarefa;
<br><br>
