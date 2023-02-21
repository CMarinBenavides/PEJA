package com.archerprop.peja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder.In;

import lombok.extern.log4j.Log4j2;

import com.archerprop.peja.entity.Usuarios;
import com.archerprop.peja.repositories.UsuarioRepositorio;

public class UsuarioService {

}
