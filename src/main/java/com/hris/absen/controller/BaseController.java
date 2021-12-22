package com.hris.absen.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isFullyAuthenticated()")
public abstract class BaseController {
}
