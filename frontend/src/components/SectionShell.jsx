export default function SectionShell({ eyebrow, title, action, children, className = '' }) {
  return (
    <section className={`section-block ${className}`.trim()} data-animate="fade-up">
      <div className="section-heading">
        <div>
          {eyebrow ? <p className="section-eyebrow">{eyebrow}</p> : null}
          {title ? <h2>{title}</h2> : null}
        </div>
        {action}
      </div>
      {children}
    </section>
  );
}
