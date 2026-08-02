# Estructuras de Datos (CCPG1034)

Materiales del curso **CCPG1034 Estructuras de Datos** (ESPOL), organizados por parcial y tópico:
diapositivas, guías, ejercicios, código Java y enlaces a recursos adicionales.

Este contenido también se publica, renderizado, en
**[stevensantillan.com/teaching/data-structures](https://stevensantillan.com/teaching/data-structures)**.
Este repositorio es la fuente de esos materiales — clónalo si prefieres tenerlos localmente o revisar
el código Java directamente.

## Organización

```
Primer Parcial (1P)
├── Big(O)
├── Comparadores
├── Conjuntos
├── Genéricos
├── Iteradores
├── Listas
├── Mapas
├── Pilas y Colas
└── Recursividad

Segundo Parcial (2P)
├── Árboles
└── Grafos
```

Cada tópico tiene dos archivos asociados:

- `content/docs/<parcial>/<topico>.mdx` — la página del tópico.
- `content/materials/<parcial>-<topico>.yaml` — el catálogo de materiales de esa página (título,
  tipo, tamaño y ruta de cada archivo).

## Estructura del repositorio

```
content/docs/       páginas MDX (índice, por parcial, por tópico)
content/materials/  catálogo YAML de materiales, uno por tópico
code/               código fuente Java mostrado en las páginas de tópico
files/              descargas públicas: PDF, PPT/PPTX y ZIP
```

## Tipos de material

- **Descargas** (PDF, PPT/PPTX, ZIP) — bajo `files/`, referenciadas por el campo `file:` del YAML.
- **Código Java** — bajo `code/`, referenciado por el campo `code:`. Se muestra como texto fuente
  para fines de lectura; no se garantiza que todos los archivos compilen de forma independiente.
- **Enlaces externos** — algunos tópicos incluyen recursos alojados en Google Drive
  (campo `url:` con `access: institucional`), que requieren una cuenta institucional de ESPOL para
  acceder. No son descargas de este repositorio.

## Licencia

Este repositorio usa dos licencias distintas:

- El código fuente (`code/`) está bajo licencia **MIT** — ver [LICENSE](LICENSE).
- El material docente (`content/`, `files/`) está bajo licencia
  **Creative Commons Attribution-NonCommercial-ShareAlike 4.0 (CC BY-NC-SA 4.0)** — ver
  [LICENSE-CONTENT.md](LICENSE-CONTENT.md).

## Autor

**Steven Santillan Padilla** — Lecturer & Researcher, ESPOL.
[stevensantillan.com](https://stevensantillan.com)
