INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`,
                                    `authorized_grant_types`, `web_server_redirect_uri`,
                                    `authorities`, `access_token_validity`,
                                    `refresh_token_validity`, `additional_information`,
                                    `autoapprove`)
VALUES (''client'', NULL, ''$2a$10$HFkYEHDzh0c64m1PZqffYOQ/L14Q4svbiLRusN9pvaIYQ4qtCe9fO'', ''app'',
        ''authorization_code'', ''http://localhost:8989/consume/redirect'', NULL, NULL, NULL, NULL,
        NULL);