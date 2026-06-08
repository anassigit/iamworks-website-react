export default function FeatureStrip({ features = [] }) {
  return (
    <div className="feature-strip" data-animate="stagger">
      {features.map((feature) => (
        <div key={feature.title} className="feature-item">
          <span className="feature-icon">◈</span>
          <div>
            <p>{feature.title}</p>
            <small>{feature.description}</small>
          </div>
        </div>
      ))}
    </div>
  );
}
