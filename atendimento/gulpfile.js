var gulp = require('gulp');
var concat = require('gulp-concat');
var es = require('event-stream');
var sass = require('gulp-sass');
var clean = require('gulp-clean');
var base = '../';
var dist = 'atendimento';
var dest = base+'dist/'+dist;

gulp.task('clean', function () {
    gulp.src(dest)
        .pipe(clean());
});
gulp.task('sass', function () {
    return es.merge([
        gulp.src([
            base+'node_modules/bootstrap/dist/css/bootstrap.min.css'
        ]),
        gulp.src('src/scss/**/*.scss')
            .pipe(sass()).on('error', sass.logError)
    ])
        .pipe(concat('style.css'))
        .pipe(gulp.dest(dest));
});


gulp.task('js',function () {
    return es.merge([gulp.src([
        base+'node_modules/angular/angular.min.js',
        base+'node_modules/angular-route/angular-route.min.js',
        base+'node_modules/jquery/dist/jquery.min.js',
        base+'node_modules/bootstrap/dist/js/bootstrap.min.js'
    ]),
        gulp.src('src/js/**/*.js')
    ]).pipe(concat('script.js'))
        .pipe(gulp.dest(dest));
});


gulp.task('html', function () {
    return es.merge([
        gulp.src('src/*.html')
            .pipe(gulp.dest(dest)),
        gulp.src('src/templates/*')
            .pipe(gulp.dest(dest+'/templates'))
    ]);
});

gulp.watch('src/scss/**/*.scss', ['sass']);
gulp.watch('src/**/*.html', ['html']);
gulp.watch('src/js/**/*.js', ['js']);

gulp.task('default', ['js', 'html', 'sass']);