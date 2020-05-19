<?php

use Slim\Routing\RouteCollectorProxy;

$app->group('/api', function(RouteCollectorProxy $group){
    $group->get('/usuarios','App\Controllers\UsuariosController:getAll');
});

