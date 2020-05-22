<?php

use Slim\App;

return function (App $app) {
    $app->get('/', \App\Action\HomeAction::class);

    /**
     * Rutas de usuario
     */
    $app->get('/usuarios/{id}', \App\Action\UsuarioGetAction::class);
    $app->post('/usuarios',     \App\Action\UsuarioCreateAction::class);
    $app->put('/usuarios',      \App\Action\UsuarioModifyAction::class);
    $app->delete('/usuarios',   \App\Action\UsuarioDeleteAction::class);

    // $app->get('/usuarios', function ($request, $response, $params) {
    //     $response->getBody()->write((string)json_encode($request->getParsedBody()));

    //     return $response;
    // });
};

?>